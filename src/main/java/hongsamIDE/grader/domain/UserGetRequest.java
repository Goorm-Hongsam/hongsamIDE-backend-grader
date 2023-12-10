package hongsamIDE.grader.domain;

import lombok.Data;

@Data
public class UserGetRequest {

    private String questionId;
    private String uuid;
}
