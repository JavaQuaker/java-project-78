### Валидатор данных

### Hexlet tests and linter status:

[![Actions Status](https://github.com/JavaQuaker/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/JavaQuaker/java-project-78/actions)
____________________________________________________________________________________________________________________________________________________________

<h3>Описание:</h3>
<p>Валидатор дает возможность проверять строки, числа, объекты Map, вложенные объекты в Map  
Валидатор работает следующим образом:
<ul>
  <li>создается объект валидатора</li>
  <li>создается и настраивается схему проверки данных </li>
  <li>после этого проводим проверку данных, используя ранее созданную схему</li>
</ul></p>

<h3>Пример использования</h3>


```
//Валидатор строк
Validator v = new Validator();
StringSchema schema = v.string();
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

//Валидатор чисел
Validator v = new Validator();
NumberSchema schema = v.number();
schema.isValid(null); // true
schema.positive().isValid(null); // true
schema.required();
schema.isValid("5"); // false
schema.range(5, 10);
schema.isValid(5); // true
schema.isValid(4); // false


//Валидация объектов типа Map
Validator v = new Validator();
MapSchema schema = v.map();
schema.isValid(null); // false
schema.isValid(new HashMap()); // true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

//Вложенная валидация
Validator v = new Validator();
MapSchema schema = v.map();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas);
Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true
```
