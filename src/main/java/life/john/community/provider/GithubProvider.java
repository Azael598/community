package life.john.community.provider;

import com.alibaba.fastjson.JSON;
import life.john.community.dto.AccessTokenDTO;
import life.john.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){

        final MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
//        Request request = new Request.Builder()
//                .url("https://github.com/login/oauth/access_token?client_id=e20e773abf2bea16747a&client_secret=a6c5cf388aecd7b30e1853969f61e9480e903033&code="+accessTokenDTO.getCode()+"&redirect_uri=http://localhost:8887/callback&state=1")
//                .post(body)
//                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            //System.out.println(string);
            String token = string.split("&")[0].split("=")[1];
            //System.out.println(token);
            return token;

        }catch (IOException e){

        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            System.out.println(string);
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            System.out.println(githubUser.getName());
            return githubUser;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
