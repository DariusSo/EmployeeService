import org.example.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.util.List;

public class TestClass {
    static EmployeeServiceImpl eImpl;
    static Manager manager;
    static Developer developer;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Test
    public void createManager(){
        //Arrange
        String name = "Darius";
        int age = 45;
        BigDecimal salary = BigDecimal.valueOf(2000.00);
        int teamSize = 10;
        //Act
        Manager manager = new Manager(name, age, salary, teamSize);
        //Assert
        Assertions.assertEquals(name, manager.getName());
        Assertions.assertEquals(age, manager.getAge());
        Assertions.assertEquals(salary, manager.getSalary());
        Assertions.assertEquals(teamSize, manager.getTeamSize());
    }
    @Test
    public void createDeveloper(){
        //Arrange
        String name = "Darius";
        int age = 45;
        BigDecimal salary = BigDecimal.valueOf(2000.00);
        Enum language = ProgrammingLanguage.JAVA;
        //Act
        Developer developer = new Developer(name, age, salary, language);
        //Assert
        Assertions.assertEquals(name, developer.getName());
        Assertions.assertEquals(age, developer.getAge());
        Assertions.assertEquals(salary, developer.getSalary());
        Assertions.assertEquals(language, developer.getProgrammingLanguage());
    }
    @Test
    public void checkManagerTeamSizeMoreThen10(){
        //Arrange
        int teamSize = 12;
        //Act
        manager.setTeamSize(teamSize);
        eImpl.performDuties(manager);
        //Assert
        Assertions.assertEquals("valdo didele komanda.\r\n", outputStreamCaptor.toString());
    }
    @Test
    public void checkManagerTeamSizeLessThen10or10(){
        //Arrange
        int teamSize = 10;
        //Act
        manager.setTeamSize(teamSize);
        eImpl.performDuties(manager);
        //Assert
        Assertions.assertEquals(manager.getName() + " valdo maza komanda\r\n", outputStreamCaptor.toString());
    }
    @Test
    public void checkDeveloperCsharpClassAndSalary(){
        //Arrange
        Enum language = ProgrammingLanguage.Csharp;
        //Act
        developer.setProgrammingLanguage(language);
        eImpl.performDuties(developer);
        //Assert
        Assertions.assertEquals("C# programuotojas, Alga: " + developer.getSalary() +"\r\n", outputStreamCaptor.toString());
    }
    @Test
    public void checkDeveloperJavaClassAndSalary(){
        //Arrange
        Enum language = ProgrammingLanguage.JAVA;
        //Act
        developer.setProgrammingLanguage(language);
        eImpl.performDuties(developer);
        //Assert
        Assertions.assertEquals("Java programuotojas, Alga: " + developer.getSalary() +"\r\n", outputStreamCaptor.toString());
    }
    @Test
    public void checkDeveloperCPlusPlusClassAndSalary(){
        //Arrange
        Enum language = ProgrammingLanguage.CplusPlus;
        //Act
        developer.setProgrammingLanguage(language);
        eImpl.performDuties(developer);
        //Assert
        Assertions.assertEquals("Reikia C++ programuotjo, Alga pagal susitarima\r\n", outputStreamCaptor.toString());
    }
    @Test
    public void checkClassAndSalary(){
        //Arrange
        Enum language = ProgrammingLanguage.CplusPlus;
        //Act
        developer.setProgrammingLanguage(language);
        eImpl.performDuties(developer);
        //Assert
        Assertions.assertEquals("Reikia C++ programuotjo, Alga pagal susitarima\r\n", outputStreamCaptor.toString());
    }
    @Test
    public void promoteManagerPlusOneTeamSize(){
        //Arrange
        manager.setTeamSize(13);
        //Act
        eImpl.promoteEmployee(manager);
        //Assert
        Assertions.assertEquals(14, manager.getTeamSize());
    }
    @Test
    public void promoteManagerMoreThan15TeamSizeBiggerSalaryBy10Percent(){
        //Arrange
        manager.setTeamSize(15);
        manager.setSalary(BigDecimal.valueOf(2000.00));
        //Act
        eImpl.promoteEmployee(manager);
        //Assert
        Assertions.assertEquals(BigDecimal.valueOf(2200.00).setScale(2, RoundingMode.HALF_UP), manager.getSalary());
    }
    @Test
    public void promoteCsharpDeveloperBy7Percent(){
        //Arrange
        developer.setSalary(BigDecimal.valueOf(2000.00));
        developer.setProgrammingLanguage(ProgrammingLanguage.Csharp);
        //Act
        eImpl.promoteEmployee(developer);
        //Assert
        Assertions.assertEquals(BigDecimal.valueOf(2140.00).setScale(2, RoundingMode.HALF_UP), developer.getSalary());
    }
    @Test
    public void promoteJavaDeveloperBy12Percent(){
        //Arrange
        developer.setSalary(BigDecimal.valueOf(2000.00));
        developer.setProgrammingLanguage(ProgrammingLanguage.JAVA);
        //Act
        eImpl.promoteEmployee(developer);
        //Assert
        Assertions.assertEquals(BigDecimal.valueOf(2240.00).setScale(2, RoundingMode.HALF_UP), developer.getSalary());
    }
    @Test
    public void raiseSalary10percentWhenPerformanceScoreMoreThan8(){
        //Arrange
        int points = 9;
        developer.setSalary(BigDecimal.valueOf(2000.00));
        manager.setSalary(BigDecimal.valueOf(2000.00));
        //Act
        eImpl.evaluatePerformance(developer, points);
        eImpl.evaluatePerformance(manager, points);
        //Assert
        Assertions.assertEquals(BigDecimal.valueOf(2200.00).setScale(2, RoundingMode.HALF_UP), developer.getSalary());
        Assertions.assertEquals(BigDecimal.valueOf(2200.00).setScale(2, RoundingMode.HALF_UP), manager.getSalary());

    }
    @Test
    public void raiseSalary5percentWhenPerformanceScore7To8(){
        //Arrange
        int points = 7;
        developer.setSalary(BigDecimal.valueOf(2000).setScale(0, RoundingMode.HALF_UP));
        manager.setSalary(BigDecimal.valueOf(2000).setScale(0, RoundingMode.HALF_UP));
        //Act
        eImpl.evaluatePerformance(developer, points);
        eImpl.evaluatePerformance(manager, points);
        //Assert
        Assertions.assertEquals(BigDecimal.valueOf(2100.00).setScale(2, RoundingMode.HALF_UP), developer.getSalary());
        Assertions.assertEquals(BigDecimal.valueOf(2100.00).setScale(2, RoundingMode.HALF_UP), manager.getSalary());

    }
    @Test
    public void dontRaiseSalaryWhenPerformanceScoreLessThan7PrintStatement(){
        //Arrange
        int points = 6;
        //Act
        eImpl.evaluatePerformance(developer, points);
        eImpl.evaluatePerformance(manager, points);
        //Assert
        Assertions.assertEquals("Darbuotojo veikla yra nepatenkinama\r\n" +
                "Darbuotojo veikla yra nepatenkinama\r\n", outputStreamCaptor.toString());

    }
    @Test
    public void checkIfListPrintsOutProperly(){
        //Arrange
        eImpl.darbuotojuSarasas();
        String s = "";
        //Act
        eImpl.listAllEmployees(eImpl.getDarbuotojuSarasas());
        for(Employee e : eImpl.getDarbuotojuSarasas()){
            s += e + "\r\n";
        }
        //Assert
        Assertions.assertEquals(s, outputStreamCaptor.toString());

    }
    @Test
    public void checkIfMethodReturnsCorrectEployeeByGivenName(){
        //Arrange
        eImpl.darbuotojuSarasas();
        developer.setName("Vladas");
        eImpl.getDarbuotojuSarasas().add(developer);
        //Act
        Employee e = eImpl.findEmployeeByName(eImpl.getDarbuotojuSarasas(), "Vladas");
        //Assert
        Assertions.assertEquals(developer, e);
    }
    @Test
    public void checkIfMethodReturnsNullEployeeByGivenName(){
        //Arrange
        eImpl.darbuotojuSarasas();
        //Act
        Employee e = eImpl.findEmployeeByName(eImpl.getDarbuotojuSarasas(), "Vladas");
        //Assert
        Assertions.assertNull(e);
    }
    @Test
    public void checkIfFiredEmployeeWasRemovedForList(){
        //Arrange
        eImpl.darbuotojuSarasas();
        //Act
        eImpl.fireEmployee(developer);
        Employee e = eImpl.findEmployeeByName(eImpl.getDarbuotojuSarasas(), developer.getName());
        //Assert
        Assertions.assertNull(e);

    }





    @BeforeAll
    public static void initialization(){
        eImpl = new EmployeeServiceImpl();
        manager = new Manager("Name", 40, BigDecimal.valueOf(2000.00), 12);
        developer = new Developer("Name", 40, BigDecimal.valueOf(2000.00), ProgrammingLanguage.JAVA);
    }
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}

