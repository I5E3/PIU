package com.example.pickitup.mapper.project.projectFile;

import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
<<<<<<< HEAD

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import org.apache.ibatis.annotations.Mapper;



=======
import org.apache.ibatis.annotations.Mapper;
>>>>>>> 718039d5105b4170035f906806aabc6fb42d1e7a
import java.util.List;

@Mapper
public interface ProjectFileMapper {
    //    해당 후기글 기본키로 file 객체 가져오기
    public List<ProjectFileVO> findProjectReviewNum(Long projectNum);

    //    해당 후기글에 작성 도중에 창을 닫는 경우 저장 경로에서 사진 지우기
    public  List<ProjectFileVO> getOldFiles();

    //    사진 입력
    public void insert(ProjectFileVO projectFileVO);

    //    사진 삭제(후기 수정시에 호출)
    public void delete(Long projectReviewNum);



}
