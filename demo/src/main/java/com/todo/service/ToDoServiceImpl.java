package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.domain.ToDoDTO;
import com.todo.mapper.ToDoMapper;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoMapper toDoMapper;

    @Override
    public List<ToDoDTO> getToDoList() { // 저장된 할 일 목록을 List(제네릭 형태로) 가져옴
        // ToDo 리스트 조회 메서드
        return toDoMapper.selectToDoList();
    }

    @Override
    public boolean insertToDoList(ToDoDTO params) {
        // 입력한 할 일을 저장
        // ToDo 리스트 추가 메서드
        int insertResult = toDoMapper.insertToDoList(params);
        return insertResult == 1;
    }

    @Override
    public boolean updateToDoList(ToDoDTO params) {
        // 할 일을 수행 했는지, 안 했는지 상태를 수정
        // ToDo 리스트 업데이트 메서드
        int updateResult = toDoMapper.updateToDoList(params);
        return updateResult == 1;
    }

    @Override
    public boolean deleteToDoList(Long idx) {
        // 할 일을 삭제 -> idx를 넘겨줘서 선택한 할 일만 삭제하도록 함
        // ToDo 리스트 삭제 메서드
        int deleteResult = toDoMapper.deleteToDoList(idx);
        return deleteResult == 1;
    }
}
