package com.blt.manager.service;

import com.blt.manager.domain.BaseResponse;
import com.blt.manager.domain.SubjectListReponse;
import com.blt.manager.domain.SubjectReponse;
import com.blt.manager.model.Schedule;
import com.blt.manager.model.StudentCourse;
import com.blt.manager.model.Subject;
import com.blt.manager.repository.ScheduleRepository;
import com.blt.manager.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    SubjectListReponse subjectListReponse;

    SubjectReponse subjectReponse;


    public SubjectListReponse getAll() {

        List<Subject> subjectList = subjectRepository.findAll();
        subjectListReponse.setSubjectList(subjectList);
        subjectListReponse.setCode("000");
        subjectListReponse.setMessage("Thành công");

        return subjectListReponse;
    }

    public SubjectReponse getById(int idSubject) {
        if(subjectRepository.findByIdSubject(idSubject)==null){
            subjectReponse.setCode("111");
            subjectReponse.setMessage("Thất bại");
        }else {
            subjectReponse.setCode("000");
            subjectReponse.setMessage("Thành công");
            subjectReponse.setSubject(subjectRepository.findByIdSubject(idSubject));
        }
        return subjectReponse;
    }

    public SubjectReponse add(Subject subject) {
        if(subjectRepository.findByName(subject.getName())!=null){
            subjectReponse.setCode("001");
            subjectReponse.setMessage("Tên môn học đã tồn tại");
        }else if(subjectRepository.findByCourseCode(subject.getCourseCode())!=null){
            subjectReponse.setCode("002");
            subjectReponse.setMessage("Mã học phần đã tồn tại");
        } else if(subject.getIdSubject()==0){
            subjectReponse.setCode("003");
            subjectReponse.setMessage("Sai id subject");
        }else if (subject.getCourseCode()==null){
            subjectReponse.setCode("004");
            subjectReponse.setMessage("Thiếu mã môn học");
        } else if (subject.getName() == null) {
            subjectReponse.setCode("005");
            subjectReponse.setMessage("Thiếu tên môn học");
        } else if (subject.getTuitionCredits() == null) {
            subjectReponse.setCode("006");
            subjectReponse.setMessage("Thiếu tín học phí");
        } else if (subject.getCourseCredits() == null) {
            subjectReponse.setCode("007");
            subjectReponse.setMessage("Thiếu tín học phần");
        }else {
            subjectReponse.setCode("000");
            subjectReponse.setMessage("Thành công");
            subjectReponse.setSubject(subject);
            subjectRepository.save(subject);
        }

        return subjectReponse;
    }

    public BaseResponse change(Subject subject) {
        if(subject.getIdSubject()==0){
            subjectReponse.setCode("003");
            subjectReponse.setMessage("Sai id subject");
        }else if (subject.getCourseCode()==null){
            subjectReponse.setCode("004");
            subjectReponse.setMessage("Thiếu mã môn học");
        } else if (subject.getName() == null) {
            subjectReponse.setCode("005");
            subjectReponse.setMessage("Thiếu tên môn học");
        } else if (subject.getTuitionCredits() == null) {
            subjectReponse.setCode("006");
            subjectReponse.setMessage("Thiếu tín học phí");
        } else if (subject.getCourseCredits() == null) {
            subjectReponse.setCode("007");
            subjectReponse.setMessage("Thiếu tín học phần");
        }else {
            subjectReponse.setCode("000");
            subjectReponse.setMessage("Thành công");
            subjectReponse.setSubject(subject);
            subjectRepository.save(subject);
        }
        return subjectReponse;
    }

}
