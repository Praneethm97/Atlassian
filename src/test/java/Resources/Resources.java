package Resources;

import StepDefinitions.Login;

public enum Resources {
    LoginApi("/rest/auth/1/session"),CreateIssue("/rest/api/2/issue"),AddCommentApi("/rest/api/2/issue/{Key}/comment"),AddAttachmentApi("/rest/api/2/issue/{Key}/attachments");
    private String resource;
    Resources(String resource){
        this.resource = resource;
    }
    public String getResource() {
        return resource;
    }
}

