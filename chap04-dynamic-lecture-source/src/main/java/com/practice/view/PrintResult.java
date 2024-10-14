package com.practice.view;

import com.practice.model.dto.MenuDTO;

import java.util.List;

public class PrintResult {
    public void successMessage(String successCode) {
        
        String successMessage = "";
        
        switch(successCode){
            case "selectByPrice" :
                successMessage = "특정금액대 조회가 성공하였습니다";
                break;
        }
    }

    public void errorMessage(String errorCode) {

        String errorMessage = "";
        switch(errorCode){
            case "selectByPrice" :
                errorMessage = "특정금액대 조회가 실패하였습니다";
                break;
        }
    }

    public void selectByMenuPrice(List<MenuDTO> menuDTOList) {

        for(MenuDTO menuDTO : menuDTOList){
            System.out.println(menuDTO);
        }
    }
}
