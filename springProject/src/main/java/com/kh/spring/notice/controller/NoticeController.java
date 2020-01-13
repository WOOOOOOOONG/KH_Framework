package com.kh.spring.notice.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.notice.model.exception.NoticeException;
import com.kh.spring.notice.model.service.NoticeService;
import com.kh.spring.notice.model.vo.Notice;

// 1. 정해진 구조의 class, interface 작성
// 2. 각각 빈 등록을 위한 어노테이션 붙여주고 서로 의존성 주입하여 결합 관계를 만들기
// 3. NoticeService라는 인터페이스에서 프로젝트에 규칙을 부여해주자

@Controller
public class NoticeController {
	@Autowired
	NoticeService nService;
	
	@RequestMapping("nlist.do")
	public ModelAndView noticeList(ModelAndView mv) {
		ArrayList<Notice> list = nService.selectList();
		
		System.out.println("list = " + list);
		
		if(list != null) {
			mv.addObject("list", list);
			mv.setViewName("notice/noticeListView");
		}else {
			throw new NoticeException("공지사항 목록 보기 실패!");
		}
		return mv;
	}
	
	@RequestMapping("nWriterView.do")
	public String nWriterView() {
		return "notice/noticeWriteForm";
	}
	
	@RequestMapping("ninsert.do")
	public String noticeInsert(Notice n, 
			@RequestParam(name="uploadFile", required=false) MultipartFile file,
			HttpServletRequest request) {
		/*System.out.println("n : " + n);
		System.out.println("파일명 : " + file.getOriginalFilename());*/
		
		// 그냥 출력하면 모든 값이 null로 나옴 --> Multipart로 넘어오기 때문
		// ==> pom.xml에 파일 업로드 관련 라이브러리를 추가해주어야 함
		
		// 라이브러리 추가 후 root-context에서 multipartResolver를 통해
		// 파일 크기 지정해주기
		
		// 넘어온 file을 폴더에 저장해주는 작업
		// 이후 공지사항 수정 시에도 같은 프로세스를 사용하기 때문에
		// 따로 메소드로 빼서 작업
		if(!file.getOriginalFilename().equals("")) {
			String savePath = saveFile(file, request);
			
			if(savePath != null ) {
				n.setFilePath(file.getOriginalFilename());
			}
		}
		
		// textarea의 개행 문자를 <br>로 변경해서 저장
		n.setnContent(n.getnContent().replace("\n", "<br>"));
		
		int result = nService.insertNotice(n);
		
		if(result > 0) {
			return "redirect:nlist.do";
		}else {
			throw new NoticeException("공지사항 등록 실패!");
		}
	}
	
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일이 저장될 경로 설정
		// 해당 resources는 webapp 하위의 resources -> 이미지, js, css 등 보관
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		// 파일의 경로는 root 하위의 nuploadFiles
		String savePath = root + "\\nuploadFiles";
		
		// System.out.println("savePath : " + savePath);
		
		File folder = new File(savePath);
		
		// 해당 폴더 위치가 존재하지 않는다면
		if(!folder.exists()) {
			folder.mkdirs(); // 해당 디렉토리들을 만든다
		}
		
		// 공지사항은 보통 관리자가 규칙을 가지고 업로드 한다고 생각하고
		// file명 rename 작업 생략 ==> 게시판에서 해보겠음
		String filePath = folder + "\\" + file.getOriginalFilename();
		// 실제 저장될 파일 경로 + 넘어온 파일명
		
		try {
			// 이 순간 서버에 파일이 저장된다.
			file.transferTo(new File(filePath));
		} catch (Exception e) {
			System.out.println("파일 전송 에러 : " + e.getMessage());
		}
		
		return filePath;
	}

	@RequestMapping("ndetail.do")
	public String noticeDetail(int nId, Notice n, Model model) {
		n = nService.selectOne(nId);
		
		System.out.println("n = " + n);
		if(n != null) {
			model.addAttribute("notice", n);
			return "notice/noticeDetailView";
		}else {
			model.addAttribute("msg", "공지사항 상세보기 실패!");
			return "common/errorPage";
		}
	}
}
