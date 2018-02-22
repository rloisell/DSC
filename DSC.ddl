alter table `Department_Category` add index `FKDepartment142191` (`CategorycategoryID`), add constraint `FKDepartment142191` foreign key (`CategorycategoryID`) references `Department` (`categoryID`);
