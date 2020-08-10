package life.john.community.Exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    Question_Not_Found("你找的问题不存在");

    @Override
    public String getMessage(){
        return message;
    }
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
