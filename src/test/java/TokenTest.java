import com.alexnine.auth.JwtUtils;
import com.alexnine.config.ConKeys;
import com.alexnine.entity.User;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @author AlexNine
 * Date 2019/5/31 14:44
 */
public class TokenTest {

    @Test
    public void testToken(){
        User user = new User(12222L,"AlexNine","aabbcc","admin");
        String token = JwtUtils.getToken(user);
        System.out.println(token);
        DecodedJWT decodedJWT = JwtUtils.decodedJWT(token);

        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getPayload());
        System.out.println(decodedJWT.getSignature());
        //md5:1a056f9e78d901f7ca933d85b9b9bc7a
        System.out.println("password_salt_hash:"+ DigestUtils.md5Hex("12345"+ConKeys.PWD_SALT));
        System.out.println("------------------------");
        System.out.println("username:"+decodedJWT.getClaim("username").asString());
        System.out.println("id:"+decodedJWT.getClaim("id").asLong());
        System.out.println("role:"+decodedJWT.getClaim("role").asString());
        System.out.println("now:"+System.currentTimeMillis());
        System.out.println("expireTime:"+decodedJWT.getExpiresAt().getTime());
    }
}
