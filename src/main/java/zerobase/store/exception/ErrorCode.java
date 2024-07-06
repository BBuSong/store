package zerobase.store.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 회원 가입
    ALREADY_REGISTER_USER(HttpStatus.BAD_REQUEST, "이미 가입된 회원입니다."),
    // 로그인
    LOGIN_CHECK_FAIL(HttpStatus.BAD_REQUEST, "아이디나 패스워드를 확인해 주세요."),
    NOT_FOUND_USER(HttpStatus.BAD_REQUEST, "해당 사용자를 찾을 수 없습니다.");


    private final HttpStatus httpStatus;
    private final String detail;
}
