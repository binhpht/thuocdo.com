select Q.questionContent, R.contentFreeText,J.account.fullName,J.account.address, year(J.account.birthday),J.account.job.jobName
from JoinSurvey J right join J.results R join R.answer A join A.question Q 
where R.contentFreeText !=null
