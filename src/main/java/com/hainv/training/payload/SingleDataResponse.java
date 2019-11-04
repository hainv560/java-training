package com.hainv.training.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Created by Hainv on 2019-11-05
 * @project docker-compose
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleDataResponse<T> {

    private T data;

}
