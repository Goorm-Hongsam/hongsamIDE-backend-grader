package hongsamIDE.grader.controller;


import hongsamIDE.grader.domain.UserGetRequest;
import hongsamIDE.grader.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class LambdaGetController implements Function<UserGetRequest, String> {

    private final S3Service s3Service;

    @Override
    public String apply(UserGetRequest userGetRequest) {
        try {
            return s3Service.getS3(userGetRequest.getUuid(), userGetRequest.getQuestionId());
        } catch (IOException e) {
            return "기본 파일 제공";
        }
    }
}