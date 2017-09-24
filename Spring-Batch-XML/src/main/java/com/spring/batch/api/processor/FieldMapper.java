package com.spring.batch.api.processor;

import org.joda.time.LocalDate;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.spring.batch.api.model.ExamResult;

/**
 * @author BASANTA
 *
 */
public class FieldMapper implements FieldSetMapper<ExamResult> {
	/**
	 * This method will act as Mapper method , it will internally convert Raw
	 * data to generic type object FieldSetMapper<ExamResult> This one is the
	 * beauty of Batch job , Think if we will do manually then what are the
	 * complex step we need to follow :
	 * 
	 * 1.Read the file using BufferedReader(Line by Line) 
	 * 2.split the line by ("|") this symbol 
	 * 3.Get index one by one and set it to ExamResult class
	 *
	 * To optimize this complex implementation spring Batch provided support for
	 * FieldSetMapper , where it can handel any type of input raw formatcause
	 * our raw data not only text file it can be csv,Excel or PDF any format .if
	 * we will write manually then we need to follow different approach for
	 * excel or csv or pdf.
	 */
	@Override
	public ExamResult mapFieldSet(FieldSet fieldSet) throws BindException {
		ExamResult examResult = new ExamResult();
		examResult.setStudentName(fieldSet.readString(0));
		examResult.setDob(new LocalDate(fieldSet.readDate(1, "dd/MM/yyyy")));
		examResult.setPercentage(fieldSet.readDouble(2));
		return examResult;
	}

}
