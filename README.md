# Aplikacja stworzona na wzór dzienników elektronicznych typu "Librus"

Funkcjonalności:<br/>
-możliwość rejestracji nowego użytkownika który może być zarówno nauczycielem jak i uczniem (Do rejestracji potrzebny jest specjalny kod, który musi wcześniej być umieszczony w bazie danych). To czy po wpisaniu kodu nowy użytkownik rejestruje się jako uczeń czy nauczyciel zależy od roli do której jest przypisany "RegisterKey".<br/>
-możliwość zalogowania (użytkownik zapisuje się w sesji)<br/>
-każdy uczeń jest przypisany do jakiejś klasy (1A, 2A, 3A, 2B,..., 3C)<br/>
-uczeń może przeglądać swoje oceny w podziale na przedmioty. Podczas przeglądania ocen uczeń widzi imię i nazwisko nauczyciela który mu wystawił owe oceny z danego przedmiotu.<br/>
-do każdej lekcji w dzienniku jest przypisany zarówno nauczyciel jak i szkolna klasa<br/>
-każdej lekcji jest też przypisany przedmiot (np. matematyka, historia)<br/>
-nauczyciel widzi klasy które uczy oraz przedmiot którego uczy w danej klasie<br/>
-nauczyciel może wybrać daną klase i przejść do panelu z widokiem na wszystkich uczniów w danej klasie. W pamelu tym może poszczególnym uczniom wystawiać oceny.<br/>
-możliwość wylogowania się<br/>

### Technologie użyte do napisania aplikacji
-Thymeleaf <br/>
-Framework Hibernate<br/>
-Framework Spring ( Spring Boot, Spring MVC)<br/>
-HTML 5<br/>
-JavaScript<br/>
-MySql (wersja 8.0.13)<br/>
