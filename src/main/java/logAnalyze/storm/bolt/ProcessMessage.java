package logAnalyze.storm.bolt;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import logAnalyze.storm.domain.LogMessage;
import logAnalyze.storm.utils.LogAnalyzeHandler;

/**
 * Describe: 对过滤后的日志进行计算
 * Author:   maoxiangyi
 * Domain:   www.itcast.cn
 * Data:     2015/11/16.
 */
public class ProcessMessage extends BaseBasicBolt {
    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        LogMessage logMessage = (LogMessage) input.getValueByField("message");
        //计算日志pv和uv
        LogAnalyzeHandler.process(logMessage);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
