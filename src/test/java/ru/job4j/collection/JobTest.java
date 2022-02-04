package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCompatorByNameAsc() {
        Comparator<Job> cmp = new JobAscByName();
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriorityAsc() {
        Comparator<Job> cmp = new JobAscByPriority();
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameDesc() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityDesc() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameDescAndProrityDesc() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAscAndProrityAsc() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}