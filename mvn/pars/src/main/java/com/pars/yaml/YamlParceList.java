package com.pars.yaml;

import com.pars.ReadFromFile;
import com.pars.User;
import com.pars.UserExt;
import com.pars.UserList;
import com.pars.UserLittle;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.util.Arrays;

public class YamlParceList {
    public static void main(String[] args) {
//        Yaml yaml = new Yaml(new Constructor(UserList.class));
        Yaml y1 = new Yaml(new Constructor(UserLittle[].class));
        String yamlStr = ReadFromFile.readToString("/Users/oleksandrstepurko/IdeaProjects/HillelSummer2023/mvn/pars/src/main/resources/user.yaml");
//        UserList user = yaml.load(yamlStr);
        UserLittle[] users = y1.load(yamlStr);

//        System.out.println(user);
        Arrays.stream(users).forEach(System.out::println);
    }
}
