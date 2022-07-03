package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.dto.ApplyDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.TempUserSerivce;
import com.example.pickitup.service.user.ApplyService;
import com.example.pickitup.service.user.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Slf4j
@RequestMapping("/project/*")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ApplyService applyService;
    private final CompanyService companyService;
    private final TempUserSerivce tempUserSerivce;


    // 프로젝트 등록 스텝
    @GetMapping("/createStep")
    public void createStep1(Long companyNum, Model model){
        model.addAttribute("company", companyService.read(companyNum));
    }

    // 프로젝트 등록 스텝폼
    @PostMapping("/createStepForm")
    public RedirectView projectCreate(ProjectVO projectVO, RedirectAttributes rttr){
        projectService.registerProject(projectVO);
        rttr.addFlashAttribute("companyNum", projectVO.getCompanyNum());
        return new RedirectView("/group/main");

    }

    // 프로젝트 수정
    @GetMapping("/modifyProject")
    public String modifyProject(Long num, Model model){
        model.addAttribute("project", projectService.read(num));
        return "project/modifyProject";

    }

    // 프로젝트 수정 폼
    @PostMapping("/modifyProjectForm")
    public String modifyProjectForm(ProjectVO projectVO){
        projectService.update(projectVO);
        return "/group/main";
    }

    // 프로젝트 삭제
    @DeleteMapping("/remove/{num}")
    @ResponseBody
    public void removeProject(Long num){
        projectService.remove(num);
    }


    // 프로젝트 상세보기
    @GetMapping("/projectDetail")
    public String projectDetail(Long num, Model model) throws ParseException {

        ProjectVO projectVO = projectService.read(num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date projectDate = sdf.parse(projectVO.getProjectDate());
        SimpleDateFormat addSdf = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 HH:mm");

        projectVO.setProjectDate(addSdf.format(projectDate));

        log.info("===============" + projectVO.getCompanyNum());
//        model.addAttribute("company", companyService.read(projectVO.getCompanyNum()));
//        model.addAttribute("project", projectVO);
//        model.addAttribute("qna", projectService.getQnAList(num));
//        model.addAttribute("img", projectService.getProjectFileList(num));
        return "/project/projectDetail";
    }
//
//    // 프로젝트 문의 작성
//    @GetMapping("/qnaWrite")
//    public void qnaWrite(Long num, Model model){
//
//        // projectNum, title -> model 사용
//        // userNum -> 쿠키 및 세션 사용
//        model.addAttribute("project", projectService.read(num));
//        model.addAttribute("user", tempUserSerivce.readUserInfo(42L));
//    }
//
//
//    // 프로젝트 문의 작성폼
//    @PostMapping("/qnaWriteForm")
//    public String qnaWriteForm(ProjectQnaVO projectQnaVO, Model model) throws ParseException {
//        // 임시
//        projectService.registerQnA(projectQnaVO);
//        // 임시
//        return  "redirect:/project/projectDetail?num=" + projectQnaVO.getProjectNum();
//
//
//
//    }
//    // 프로젝트 문의 수정
//
//
//    // 프로젝트 찜 추가
//    @PostMapping("/jjim")
//    @ResponseBody
//    public void addJjim(@RequestBody JjimVO jjimVO){
//        projectService.addJjim(jjimVO);
//    }
//
//    // 프로젝트 찜 해제
//    @DeleteMapping("/jjim")
//    @ResponseBody
//    public void removeJjim(@RequestBody JjimVO jjimVO){
//        projectService.removeJjim(jjimVO);
//    }
//
//
//    // 프로젝트 지원
//    @PostMapping("/apply")
//    @ResponseBody
//    public void applyProject(@RequestBody ApplyVO applyVO){
//        applyService.apply(applyVO);
//    }
//
//    // 유저 프로젝트 시작
//    @GetMapping("/apply/start")
//    @ResponseBody
//    public void userStart(@RequestBody ApplyDTO applyDTO){
//        applyService.userStart(applyDTO);
//    }
//
//    // 유저 프로젝트 종료
//    @GetMapping("/apply/end")
//    @ResponseBody
//    public void userEnd(@RequestBody ApplyDTO applyDTO){
//        applyService.userEnd(applyDTO);
//    }
//
//
//    // 유저 프로젝트 완료
//    @GetMapping("/apply/finish/{num}")
//    @ResponseBody
//    public void userFinish(@PathVariable("num") Long num){
//        applyService.userFinish(num);
//    }
//
//    // 프로젝트 지원한 유저 목록
//    @GetMapping("/apply/list/{projectNum}")
//    @ResponseBody
//    public List<ApplyDTO> getApplyUser(@PathVariable("projectNum") Long projectNum){
//        return applyService.getApplyUser(projectNum);
//    }
//
//    // 후기 작성
//    // 세션에서 작성자 정보 확인
//    @GetMapping("/review/add/{projectNum}/{userNum}")
//    public String addReview(Long projectNum, Long userNum, Model model){
//        model.addAttribute("user",tempUserSerivce.readUserInfo(userNum));
//        model.addAttribute("projectNum", projectNum);
//        return "/project/projectReviewWrite";
//
//    }
//
//    // 후기 작성폼
//    @PostMapping("/review/add")
//    public String addReviewForm(ProjectReviewVO projectReviewVO, Model model){
//        projectReviewVO.setUserNum(41L);
//        projectReviewVO.setProjectNum(41L);
//        projectService.registerReview(projectReviewVO);
//
//        return reivewList(41L, model);
//    }
//
//    // 후기 목록
//    @GetMapping("/review/list")
//    public String reivewList(Long projectNum, Model model){
//        model.addAttribute("reviews", projectService.getProjectReviewList(41L));
//        return "project/projectReviewAll";
//    }
//
//    // 후기 수정
//    @GetMapping("/review/modify")
//    public String modifyForm(Long num, Model model){
//        log.info("======================" + num);
//        model.addAttribute("review", projectService.readReview(num));
//        return "/project/projectReviewModify";
//
//    }
//
//    // 후기 수정
//    @PostMapping("/review/modify")
//    public String modifyReviewForm(ProjectReviewVO projectReviewVO, Model model){
//        projectReviewVO.setUserNum(41L);
//        projectReviewVO.setProjectNum(41L);
//        projectService.modifyReview(projectReviewVO);
//        return addReview(41L, 41L, model);
//    }
//
//    @ResponseBody
//    @DeleteMapping("/review/remove/{reviewNum}")
//    public void removeReview(@PathVariable("reivewNum") Long reviewNum){
//        projectService.removeReview(reviewNum);
//    }
//
//
//
//
//


}
