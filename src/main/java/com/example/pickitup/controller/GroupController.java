package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.dto.PageDTO;
import com.example.pickitup.domain.vo.user.CompanyVO;
import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.TempAdminService;
import com.example.pickitup.service.user.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/group/*")
public class GroupController {
    private final TempAdminService tempAdminService;
    private final ProjectService projectService;
    private final CompanyService companyService;


    // 그룹 메인
    @GetMapping("/main")
    public void main(Model model, Criteria criteria){
        model.addAttribute("projectList", projectService.getProjectList(10L,criteria ));

    }

    // 그룹 공지사항
    @GetMapping("/notice")
    public String notice(Criteria criteria, Model model){
        model.addAttribute("adminBoardList", tempAdminService.getNoticeList(criteria));
        model.addAttribute("pageDTO", new PageDTO(criteria, tempAdminService.getNoticeTotal()));
        return "group/notice";
    }

    // 그룹 공지사항 상세보기
    @GetMapping("/noticeDetail")
    public void noticeDetail(Long num, Criteria criteria, HttpServletRequest request, Model model) {
        String requestURL = request.getRequestURI();
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        log.info("*************");
        log.info("================================");
        log.info(criteria.toString());
        log.info("================================");
        model.addAttribute("adminBoard", tempAdminService.getReadDetail(51L));

    }

    // 그룹 프로필 수정
    @GetMapping("/modify")
    public String modify(Model model){
        model.addAttribute("company", companyService.read(10L));
        return "/group/modify";
    }


    // 그룹 프로필 수정 폼
    @PostMapping("/modifyForm")
    public String modifyForm( CompanyVO companyVO, Model model){
        companyVO.setNum(10L);
        companyService.update(companyVO);
        return modify(model);
    }

    // 그룹 QnA
    @GetMapping("/qna")
    public void qna(CompanyVO companyVO){

    }



}
