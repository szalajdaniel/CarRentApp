package com.example.carrent.Service;

import com.example.carrent.Model.Report;
import com.example.carrent.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public void saveReport(Report report) {
        report.setIsResolved(false);
        reportRepository.save(report);
    }

    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }

    public List<Report> getAllResolvedReports(){
        return reportRepository.findByIsResolvedTrue();
    }

    public List<Report> getAllUnresolvedReports(){
        return reportRepository.findByIsResolvedFalse();
    }

    public Report findById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    public void markAsResolved(Long id) {
        Report report = findById(id);
        if (report != null) {
            report.setIsResolved(true);
            reportRepository.save(report);
        }
    }

    public void markAsUnresolved(Long id) {
        Report report = findById(id);
        if (report != null) {
            report.setIsResolved(false);
            reportRepository.save(report);
        }
    }

    public void save(Report report) {
        reportRepository.save(report);
    }
}
