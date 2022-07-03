<<<<<<< HEAD
package com.example.pickitup.mapper.project.projectQna;

import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProjectQnaMapper {

    //    qna 전체 띄우기 무한 스크롤
//    projectQna.num 을 이용하여 comment를 바로 밑에 띄워줘야함
    public List<ProjectQnaVO> getList(Long projectNum);

//    qan 상세보기 class101에 없음 qna+comment 세트로 불러옴
//    관리자에서 필요함 관리자가 댓글 달아준것만 리스트 업
//    public List<ProjectQnaVO> getDetail(Long projectNum);

    //    qna 삽입
    public void insert(ProjectQnaVO projectQnaVO);

    //    qna 수정하기
    public boolean update(ProjectQnaVO projectQnaVO);

    //    qna 삭제하기 qna 글 기본키 받아오기
    public boolean delete(Long num);


}
=======
package com.example.pickitup.mapper.project.projectQna;

import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProjectQnaMapper {

    //    qna 전체 띄우기 무한 스크롤
//    projectQna.num 을 이용하여 comment를 바로 밑에 띄워줘야함
    public List<ProjectQnaVO> getList(Long projectNum);

//    qan 상세보기 class101에 없음 qna+comment 세트로 불러옴
//    관리자에서 필요함 관리자가 댓글 달아준것만 리스트 업
//    public List<ProjectQnaVO> getDetail(Long projectNum);

    // 문의글 정보 불러오기 (수정)
    public ProjectQnaVO getDetail(Long num);
    //    qna 삽입
    public void insert(ProjectQnaVO projectQnaVO);

    //    qna 수정하기
    public boolean update(ProjectQnaVO projectQnaVO);

    //    qna 삭제하기 qna 글 기본키 받아오기
    public boolean delete(Long num);





}
>>>>>>> 383d576e94bb33cf289090cbcbef6df83f1d4878
