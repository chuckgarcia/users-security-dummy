package mx.charly.userssecurity.rest;

import lombok.extern.apachecommons.CommonsLog;
import mx.charly.userssecurity.dto.UserDto;
import mx.charly.userssecurity.service.UserService;
import mx.charly.userssecurity.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Risko
 * @since 16/11/2016.
 */
@CommonsLog
@RestController
@RequestMapping(value = "/user")
public class UserRest {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces="application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity<?> userLogin(@RequestParam String usrname) {
        try {
            UserDto userDto = userService.findByUserName(usrname);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (RuntimeException runEx) {
            log.error(runEx.getMessage(), runEx);
            return new ResponseEntity<>(new ResponseVo(runEx.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
