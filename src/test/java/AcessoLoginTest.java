import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcessoLoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void desligar() {
        driver.quit();
    }

    @Test

    public void login() {
        driver.get("https://the-internet.herokuapp.com/login");

        // Teste 1 - Login em branco e senha em branco
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Validar mensagem de erro
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);

        // Teste 2 - Login em branco e senha errada
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("Senha123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Validar mensagem de erro
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);

        // Teste 3 - Login em branco e senha correta
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Validar mensagem de erro
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);

        // Teste 4 - Login errado e senha em branco
        driver.findElement(By.id("username")).sendKeys("Login123");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Validar mensagem de erro
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);

        // Teste 5 - Login errado e senha errada
        driver.findElement(By.id("username")).sendKeys("Login123");
        driver.findElement(By.id("password")).sendKeys("Senha123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Validar mensagem de erro
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);

        // Teste 6 - Login errado e senha correta
        driver.findElement(By.id("username")).sendKeys("Login123");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Validar mensagem de erro
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);

        // Teste 7 - Login correto e senha em branco
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Validar mensagem de erro
        assertEquals("Your password is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);

        // Teste 8 - Login correto e senha errada
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("Senha123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Validar mensagem de erro
        assertEquals("Your password is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);

        // Teste 9 - Login correto e senha correta - Acesso permitido
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // transição de tela

        // Validar mensagem de sucesso
        assertEquals("You logged into a secure area!", driver.findElement(By.id("flash")).getText().split("\n")[0]);

        // Voltar para tela principal
        // driver.findElement(By.xpath("//*[contains(@class, 'button') and contains(@class, 'secondary') and contains(@class, 'radius')]")).click();
    }
}
