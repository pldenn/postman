import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class PostmanTest {

    @Test
    public void test(){
// Given - When - Then
// Предусловия

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=utf-8")
                .body("тест") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .log().all()
                .when()
                .post("/post")

// Проверки
                .then()
                .log().all()

                .statusCode(200)
                .header("content-type","application/json; charset=utf-8")

                .body("data.", is("тест fail"))
                .body("data", equalTo("тест fail"))
        ;
    }
}
