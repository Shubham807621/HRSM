package com.hrsm.HRSM.service;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.BankInfo;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.repo.BankInfoRepo;
import com.hrsm.HRSM.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankInfoService {

    @Autowired
    private BankInfoRepo bankInfoRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public BankInfo createBankInfo(BankInfo bankInfo, String empId) {

        Employee employee = employeeRepo.findByEmpId(empId);

        BankInfo bankInfo1 = BankInfo.builder()
                .employee(employee)
                .bankName(bankInfo.getBankName())
                .accountNumber(bankInfo.getAccountNumber())
                .ifscCode(bankInfo.getIfscCode())
                .Branch(bankInfo.getBranch())
                .build();
        return bankInfoRepo.save(bankInfo1);
    }

    public RegistrationResponse updateBankInfo(BankInfo bankInfo, String empId) {

        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with empId: " + empId);
        }

        // Check if bank info already exists
        BankInfo existingBankInfo = bankInfoRepo.findByEmployee(employee);

        if (existingBankInfo != null) {
            // Update existing record
            existingBankInfo.setBankName(bankInfo.getBankName());
            existingBankInfo.setAccountNumber(bankInfo.getAccountNumber());
            existingBankInfo.setIfscCode(bankInfo.getIfscCode());
            existingBankInfo.setBranch(bankInfo.getBranch());

            bankInfoRepo.save(existingBankInfo);
        } else {
            // Create a new record if not exists
            BankInfo newBankInfo = BankInfo.builder()
                    .employee(employee)
                    .bankName(bankInfo.getBankName())
                    .accountNumber(bankInfo.getAccountNumber())
                    .ifscCode(bankInfo.getIfscCode())
                    .Branch(bankInfo.getBranch())
                    .build();

            bankInfoRepo.save(newBankInfo);
        }

        return RegistrationResponse.builder()
                .code(200)
                .message("Details Updated")
                .build();
    }
}
