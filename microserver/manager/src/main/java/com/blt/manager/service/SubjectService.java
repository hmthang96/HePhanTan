package com.blt.manager.service;

import com.blt.manager.domain.BaseResponse;
import com.blt.manager.domain.SubjectListReponse;

import com.blt.manager.domain.SubjectReponse;

import com.blt.manager.model.Schedule;
import com.blt.manager.model.Subject;
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
        subjectListReponse = new SubjectListReponse();

        List<Subject> subjectList = subjectRepository.findAll();
        subjectListReponse.setSubjectList(subjectList);
        subjectListReponse.setCode("000");
        subjectListReponse.setMessage("Thành công");

        return subjectListReponse;

    }

    public SubjectReponse getById(int idSubject) {
        subjectReponse = new SubjectReponse();
//        int idSubject = Integer.valueOf(idSubject1);
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
        System.out.println(subject.getIdSubject());
        System.out.println(subject.getName());
        System.out.println(subject.getCourseCode());
        System.out.println(subject.getCourseCredits());
        System.out.println(subject.getTuitionCredits());
        subjectReponse = new SubjectReponse();
        if(subjectRepository.findByName(subject.getName())!=null){
            subjectReponse.setCode("001");
            subjectReponse.setMessage("Tên môn học đã tồn tại");
        }else if(subjectRepository.findByCourseCode(subject.getCourseCode())!=null){
            subjectReponse.setCode("002");
            subjectReponse.setMessage("Mã học phần đã tồn tại");
        } else if (subject.getCourseCode()==null){
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
        subjectReponse = new SubjectReponse();
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

    public SubjectReponse delete(Subject subject) {
        subjectReponse = new SubjectReponse();
        Subject subject1 = subjectRepository.findByIdSubject(subject.getIdSubject());
        if (subject1 == null){
            subjectReponse.setCode("022");
            subjectReponse.setMessage("môn học không tồn tại");
        } else if (subject.getName().equals(subject1.getName())) {
            subjectReponse.setCode("023");
            subjectReponse.setMessage("không trùng tên môn học");
        } else if (subject.getCourseCode().equals(subject1.getCourseCode())) {
            subjectReponse.setCode("024");
            subjectReponse.setMessage("không trùng mã học");
        } else if (subject.getCourseCredits().equals(subject1.getCourseCredits())) {
            subjectReponse.setCode("025");
            subjectReponse.setMessage("không trùng tín học phần");
        } else if (subject.getTuitionCredits().equals(subject1.getTuitionCredits())) {
            subjectReponse.setCode("026");
            subjectReponse.setMessage("không trùng tín học phí");
        } else {
            subjectReponse.setCode("000");
            subjectReponse.setMessage("Thành công");
            subjectReponse.setSubject(subject1);
            subjectRepository.delete(subject1);
        }


        return subjectReponse;
    }
}
