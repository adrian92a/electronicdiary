# Aplikacja webowa stworzona na wzór dzienników elektronicznych typu "Librus"
Aplikacja  opiera się na połączeniu logiki systemowej (serwera) z bazą danych oraz wyświetlaniu w odpowiedni sposób danych na stronie web 
### Funkcjonalności:
-możliwość rejestracji nowego użytkownika który może być zarówno nauczycielem jak i uczniem (Do rejestracji potrzebny jest specjalny kod, który musi wcześniej być umieszczony w bazie danych). To czy po wpisaniu kodu nowy użytkownik rejestruje się jako uczeń czy nauczyciel zależy od roli do której jest przypisany "RegisterKey".<br/>
<br/>
-możliwość zalogowania (użytkownik zapisuje się w sesji)<br/>
<br/>
-każdy uczeń jest przypisany do jakiejś klasy (np.1A, 2A, 3A, 2B,..., 3C)<br/>
<br/>
-uczeń może przeglądać swoje oceny w podziale na przedmioty. Podczas przeglądania ocen uczeń widzi imię i nazwisko nauczyciela który mu wystawił daną ocene z danego przedmiotu.<br/>
<br/>
-do każdej lekcji w dzienniku jest przypisany zarówno nauczyciel jak i szkolna klasa<br/>
<br/>
-każdej lekcji jest też przypisany przedmiot (np. matematyka, historia)<br/>
<br/>
-nauczyciel widzi klasy które uczy oraz przedmiot którego uczy w danej klasie<br/>
<br/>
-nauczyciel może wybrać daną klase i przejść do panelu z widokiem na wszystkich uczniów w danej klasie. W panelu tym może poszczególnym uczniom wystawiać oceny.<br/>
<br/>
-nauczyciel może przeglądać oraz edytować wystawione oceny
<br/>
-możliwość wylogowania się
  <br/>
<br/>
-dodana walidacja wszystkich formularzy przy użyciu  Spring, JavaScript jak i zwykłego HTML<br/>
<br/>
-Do aplikacji została dodana duża baza testowa zarejestrowanych użytkowników( baza testowa jest dodawana tylko przy pierwszym uruchomieniu programu) <br/>
<br/>
### Przykładowe dane do logowania
-janpedz@szkola.com
-kjanpedz@szkola.com
-ferkiep@szkola.com
-eugjab@szkola.com
-dobczer@szkola.com
-jadszcz@szkola.com
-bar@szkola.com
-miesz@szkola.com
-jerz@szkola.com
-mil@szkola.com
### Wszyscy użytkownicy mają to samo hasło: "hasloniedozgadniecia"



### Technologie użyte do napisania aplikacji
-Java(1.8) <br/>
-Thymeleaf <br/>
-Framework Hibernate<br/>
-Framework Spring ( Spring Boot, Spring MVC)<br/>
-HTML 5<br/>
-JavaScript<br/>
-MySql (wersja 8.0.13)<br/>
