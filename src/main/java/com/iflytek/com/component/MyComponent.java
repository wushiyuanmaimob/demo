package com.iflytek.com.component;

import com.iflytek.com.event.MyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    private final ApplicationEventPublisher applicationEventPublisher;

    public MyComponent(ApplicationEventPublisher applicationEventPublisher, Cat cat) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void run() {
        applicationEventPublisher.publishEvent(new MyEvent(this, "test"));
    }
}
