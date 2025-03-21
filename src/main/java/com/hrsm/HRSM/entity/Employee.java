    package com.hrsm.HRSM.entity;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.LocalDate;
    import java.util.List;
    import java.util.UUID;

    @Entity
    @Data
    @Table(name = "employees")
    @AllArgsConstructor
    @NoArgsConstructor
    public class Employee {

        @Id
        @GeneratedValue
        private UUID id;

        @Column(name = "emp_id", unique = true, nullable = false)
        private String empId;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "designation", nullable = false)
        private String designation;

        @Column(name = "experience")
        private String totalExperience;

        @Column(name = "client_id")
        private String clientId;

        @Column(name = "team")
        private String team;

        @Column(name = "date_of_joining")
        private LocalDate dateOfJoining;

        @Enumerated(EnumType.STRING)
        private EmployeeStatus status;

        @Column(name = "reporting_office")
        private String reportingOffice;

        @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private PersonalInfo personalInfo;

        @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<LeaveRequest> leaveRequest;

        @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private Payroll payroll;

        @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Attendance> attendance;

    //    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //    private Department department;

        @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private BasicInfo basicInfo;

        @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private BankInfo bankInfo;

        @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private FamilyInfo familyInfo;

        @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<EducationDetails> educationDetails;

        @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Experience> experiences;

        private boolean active;

    }