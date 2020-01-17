package mirea.dimedrol.edu.Dto;

import lombok.Data;
import mirea.dimedrol.edu.Model.RoleDao;
import mirea.dimedrol.edu.Model.UserDao;
import mirea.dimedrol.edu.Model.UserRole;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoleDto {
    String name;
    List<UserDto> users; //redundant for a while

    public RoleDto(RoleDao role) {
        this.name = role.getName();
//        for (UserDao user: role.getUsers())
//            this.users.add(new UserDto(user));
    }


}
