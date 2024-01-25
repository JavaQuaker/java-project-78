<h5>Валидатор данных</h5>

### Hexlet tests and linter status:
[![Actions Status](https://github.com/JavaQuaker/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/JavaQuaker/java-project-78/actions)

<h3>Описание:</h3>
<p>Валидатор дает возможность проверять строки, числа, объекты Map, вложенные объекты в Map  
Валидатор работает следующим образом:
<ul>
  <li>создается объект валидатора</li>
  <li>создается и настраивается схему проверки данных </li>
  <li>после этого проводим проверку данных, используя ранее созданную схему</li>
</ul></p>

<h3>Пример использования</h3>
<p>import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

Validator v = new Validator();

StringSchema schema = v.string();

// Пока не вызван метод required(), null и пустая строка считаются валидным
schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid(5); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false
</p>
