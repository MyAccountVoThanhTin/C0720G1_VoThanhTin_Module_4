package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

@Aspect
public class StudentLogger {

    @AfterThrowing(pointcut = "execution(public * com.example.service.StudentService.*(..))",
            throwing = "e")
    public void checkError(JoinPoint joinPoint, Exception e) {
        Class returnTypeClass = ((MethodSignature) joinPoint.getSignature()).getReturnType();
        String name = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(
                            new File("src/main/java/com/example/log/error.txt"), true));

            bufferedWriter.write(
                    String.format("%s | %s | %s | %s", returnTypeClass, name, methodName, args)
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
