package sample;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 파일을 읽어서 단어의 수를 계산하여 그 결과를 파일에 저장
 */

public class WordCount {

//    public static class MyMapper
//            extends Mapper<LongWritable, Text, Text, LongWritable> {
//        // 출력 key, value
//        private final static LongWritable one = new LongWritable(1);
//        private Text word = new Text();
//
//        @Override
//        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//
//            String line = value.toString();
//            StringTokenizer itr = new StringTokenizer(line,
//                    "\t\r\n\f :;,.()<>");   // 단어들을 해당 문자열단위로 자름
//            while (itr.hasMoreTokens()) {   // 단어들을 다 자를때까지
//                word.set(itr.nextToken());
//                context.write(word, one);
//            }
//        }
//    }

    public static class MyMapper
                              //입력 값              내보내는 값
                        //      키       밸류   값 텍스트 숫자
            extends Mapper<LongWritable, Text, Text, LongWritable> {
        // 출력 key, value
        private final static LongWritable one = new LongWritable(1);
        private Text word = new Text();

        @Override
        protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
                throws IOException, InterruptedException {

            String line = value.toString();
            StringTokenizer itr = new StringTokenizer(line,
                    "\t\r\n\f :;,.()<>");
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                context.write(word, one);
            }
        }


    }


//    public static class MyReducer
//            extends Reducer<Text, LongWritable, Text, LongWritable> {
//
//        private LongWritable result = new LongWritable();
//
//        @Override
//        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
//            int sum = 0;
//            for (LongWritable val : values) {
//                sum += val.get();
//            }
//            result.set(sum);
//            context.write(key, result);
//        }
//    }

    public static class MyReducer
            extends Reducer<Text, LongWritable, Text, LongWritable> {

        private LongWritable result = new LongWritable();

        @Override
        protected void reduce(Text key, Iterable<LongWritable> values,
                              Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {

            int sum = 0;
            for (LongWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }


    }


    public static void main(String[] args) throws Exception {


        Configuration conf = new Configuration();
        if (args.length != 2) {
            System.err.println("Usage: WordCount <input> <output>");
            System.exit(2);
        }


        Job job = Job.getInstance(conf, "WordCount");


        job.setJarByClass(WordCount.class); // 나중에 jar로 실행해야 함
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);


        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);    // 하둡에서 쓰이는 자바의 Long 형


        job.setInputFormatClass(TextInputFormat.class); // text형식 지정
        job.setOutputFormatClass(TextOutputFormat.class);


        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));


        job.waitForCompletion(true);    // 작업이 끝날때까지 대기
    }

}
