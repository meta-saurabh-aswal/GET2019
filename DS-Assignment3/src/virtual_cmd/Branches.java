package virtual_cmd;

public class Branches
{
	Branches nextBr;
	Dir child;
	Dir parentDir;
	
	Branches(Dir child, Dir parentDir)
	{
		this.child = child;
		this.nextBr = null;
		this.parentDir = parentDir;
	}

}
