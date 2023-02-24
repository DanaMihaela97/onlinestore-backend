package com.sda.onlinestore.convertor;

import com.sda.onlinestore.dto.AuthorInfoDto;
import com.sda.onlinestore.entity.Author;

public class AuthorConverter {

    public static AuthorInfoDto entityToInfo(Author author){
        AuthorInfoDto authorInfoDto = new AuthorInfoDto();
        authorInfoDto.setName(author.getName());
        return authorInfoDto;
    }


}
