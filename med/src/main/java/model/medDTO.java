package model;

public class medDTO {

    public Long m_id;
    public Long count;

    public medDTO(Long m_id, Long count) {
        this.m_id = m_id;
        this.count = count;
    }

    public medDTO(Long m_id) {
        this.m_id = m_id;
        this.count = 0L;
    }
}
