package mx.charly.userssecurity.service;

import mx.charly.userssecurity.dto.UserDto;

/**
 * @author Risko
 * @since 14/11/2016.
 */
public interface UserService {

    /**
     * Find an user by id
     * @param id user id in database
     * @return UserDto from database
     */
    UserDto findByPk(Integer id);

    /**
     * Find an user by username
     *
     * @param userName login username
     * @return UserDto from database
     */
    UserDto findByUserName(String userName);

    /**
     * save an user in database
     *
     * @param userDto Persistence object
     */
    void saveUser(UserDto userDto);

    /**
     * delete an user from database
     *
     * @param userDto Persistence object with user data to delete.
     */
    void deleteUser(UserDto userDto);

}
