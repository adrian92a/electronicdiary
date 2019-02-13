
Dziennik elektroniczny -- Aplikacja Adrian Skorupa

Aplikacja stworzona na wzór dzienników elektronicznych typu "Librus"

Funkcjonalności:
-możliwość rejestracji nowego użytkownika który może być zarówno nauczycielem jak i uczniem (Do rejestracji potrzebny jest specjalny kod, który musi wcześniej być umieszczony w bazie danych). To czy po wpisaniu kodu nowy użytkownik rejestruje się jako uczeń czy nauczyciel zależy od roli do której jest przypisany "RegisterKey".
-możliwość zalogowania (użytkownik zapisuje się w sesji)
-każdy uczeń jest przypisany do jakiejś klasy (1A, 2A, 3A, 2B,..., 3C)
-uczeń może przeglądać swoje oceny w podziale na przedmioty. Podczas przeglądania ocen uczeń widzi imię i nazwisko nauczyciela który mu wystawił owe oceny z danego przedmiotu.
-do każdej lekcji w dzienniku jest przypisany zarówno nauczyciel jak i szkolna klasa
-każdej lekcji jest też przypisany przedmiot (np. matematyka, historia)
-nauczyciel widzi klasy które uczy oraz przedmiot którego uczy w danej klasie
-nauczyciel może wybrać daną klase i przejść do panelu z widokiem na wszystkich uczniów w danej klasie. W pamelu tym może poszczególnym uczniom wystawiać oceny.
-możliwość wylogowania się

Technologie użyte do napisania aplikacji
-Thymeleaf
-Framework Hibernate
-Framework Spring ( Spring Boot, Spring MVC)
-HTML 5
-JavaScript
-MySql (wersja 8.0.13)
