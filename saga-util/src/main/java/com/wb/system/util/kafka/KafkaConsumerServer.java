package com.wb.system.util.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * kafka监听器启动
 * 自动监听是否有消息需要消费
 * @author wangb
 *
 */
public class KafkaConsumerServer implements MessageListener<String, String> {

    /**
     * 监听器自动执行该方法
     *     消费消息
     *     自动提交offset
     *     执行业务代码
     *     （high level api 不提供offset管理，不能指定offset进行消费）
     */
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("=============kafkaConsumer开始消费=============");
        String topic = record.topic();
        String key = record.key();
        String value = record.value();
        long offset = record.offset();
        int partition = record.partition();
        System.out.println("-------------topic:"+topic);
        System.out.println("-------------value:"+value);
        System.out.println("-------------key:"+key);
        System.out.println("-------------offset:"+offset);
        System.out.println("-------------partition:"+partition);
        System.out.println("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
    }

}
