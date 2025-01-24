package hello.servlet_practice.web.frontcontroller.v3;

import hello.servlet_practice.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
