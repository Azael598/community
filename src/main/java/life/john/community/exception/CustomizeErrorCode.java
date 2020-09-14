package life.john.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    Question_Not_Found(2001,"你找的问题不存在"),
    TARGET_PARAM_Not_Found(2002,"未选中任何问题进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登陆后重试"),
    SYS_ERROR(2004,"服务器冒烟了，要不然你稍后试试"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在，换个试试？"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2008,"非法读取他人信息"),
    NOTIFICATION_NOT_FOUND(2009,"消息无法找到");


    @Override
    public String getMessage(){
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
