/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.dronworks;

public class App {
    public String getGreeting() {
        return System.getenv("GRADLE_USER_HOME");
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
