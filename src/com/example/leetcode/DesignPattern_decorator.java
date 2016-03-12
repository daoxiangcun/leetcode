package com.example.leetcode;
/**
 * 装饰模式
 * 在原有的Component基础上扩展新的功能,避免采用继承的方式
 */
public class DesignPattern_decorator {
    interface IComponent {
        void operation();
    }

    public static class ConcreteComponent implements IComponent {
        @Override
        public void operation() {
            System.out.println("ConcreteComponent");
        }
    }

    public static class Decorator implements IComponent {
        IComponent component;
        public Decorator(IComponent component) {
            this.component = component;
        }

        public void operation() {
            component.operation();
        }
    }

    public static class ConcreteDecorator extends Decorator {
        public ConcreteDecorator(IComponent component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();
            System.out.println("ConcreteComponent");
        }
    }
}
