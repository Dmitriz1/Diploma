# Предусловия для запуска
- Клонированный репозиторий в IDE
- Запущенный IntelliJ IDEA
- Запущенный Docker Desktop
# Запуск
- В терминале ввести команду: docker-compose up
- Во второй вкладке терминала после запуска контейнера (обязательно проверить запуск в Docker), ввести команду: java '-Dspring.datasource.url=jdbc:mysql://localhost:3306/app' -jar ./artifacts/aqa-shop.jar (для MySQL) или  java '-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app' -jar ./artifacts/aqa-shop.jar
для (PostgreSQL)
- После запуска открыть командную строку при помощи двойного нажатия Ctrl и ввести команду: gradlew clean test '-Ddb.url=jdbc:mysql://localhost:3306/app' (для MySQL) или gradlew clean test '-Ddb.url=jdbc:postgresql://localhost:5432/app' (для PostgreSQL)
# Формирование отчёта
- В командной строке после проведения всех тестов ввести команду: gradlew allureReport
- Чтобы посмотреть отчёт - ввести команду: gradlew allureServe
- Чтобы закончить просмотр отчёта - закрыть вкладку или нажать "Ctrl + C"
