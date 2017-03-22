package CourseSchedule;

import java.util.ArrayList;

/**
 * Created by Xiaojun YU on 2017-03-20.
 */
public class Solution {
    static class Course{
        private boolean vis;
        private boolean done;
        private ArrayList<Course> pre = new ArrayList<>();

        public void addPre(Course preCourse) {
            pre.add(preCourse);
        }

        boolean isCyclinc() {
            if (done) return false;
            if (vis) return true;
            vis = true;

            for (Course preCourse: pre) {
                if (preCourse.isCyclinc()) {
                    return true;
                }
            }

            vis = false;
            done = true;
            return false;
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Course clist[] = new Course[numCourses];

            for(int i = 0; i < numCourses; i++) {
                clist[i] = new Course();
            }

            for (int[] couple: prerequisites) {
                Course c1 = clist[couple[0]];
                Course c2 = clist[couple[1]];
                c1.addPre(c2);
            }

            for (int i = 0; i< numCourses; i++) {
                if(clist[i].isCyclinc()) {
                    return false;
                }
            }
            return true;
        }

    }
}
