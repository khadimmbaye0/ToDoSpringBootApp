package com.firstappwithspringboot.todospringbootapp.entities;

import java.time.LocalDateTime;

public class CalculusMethod {
    public LocalDateTime getFinihDate(LocalDateTime beginDate, Integer duration) {
        return beginDate.plusDays(duration);
    }
}
