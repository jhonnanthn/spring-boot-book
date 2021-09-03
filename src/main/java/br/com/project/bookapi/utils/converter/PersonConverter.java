package br.com.project.bookapi.utils.converter;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import br.com.project.bookapi.entity.Person;

public class PersonConverter implements DynamoDBTypeConverter<String, Person> {

    @Override
    public String convert(Person object) {
        Person items = (Person) object;
        System.out.println(items);
        String person = null;
        try {
            if (items != null) {
                person = String.format("%s x %s x %s", items.getFullName(), items.getBirthday(),
                    items.getCpf());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person unconvert(String s) {

        System.out.println(s);
    	Person itemDimension = new Person();
        try {
            if (s != null && s.length() != 0) {
                String[] data = s.split("x");
                itemDimension.setFullName(data[0].trim());
                itemDimension.setBirthday(new Date(data[1].trim()));
                itemDimension.setCpf(Long.parseLong(data[2].trim()));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return itemDimension;
    }
}