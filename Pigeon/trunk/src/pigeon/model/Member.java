/*
    Copyright (C) 2005, 2006, 2007, 2008  Paul Richards.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package pigeon.model;

import java.io.Serializable;

/**
    Represents a single member within the organization.

    Equality and hashing are based only on the member's name.
*/
public final class Member implements Serializable, Comparable<Member> {

    private static final long serialVersionUID = 3235931567494968807L;

    // Only populated in FEDERATION mode, null otherwise
    private String club;
    // Only populated in FEDERATION mode, null otherwise
    private String section;

    private String name;
    private String address;
    private String telephone;
    private String SHUNumber;

    public Member() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidationException {
        name = name.trim();
        if (name.length() == 0) {
            throw new ValidationException("Member name is empty");
        }
        this.name = name;
    }
    
    private String getNameAndClubAndSection() {
        StringBuffer result = new StringBuffer(this.getName());
        if (this.getClub() != null) {
            result.append(", " + this.getClub());
        }
        if (this.getSection() != null) {
            result.append(", " + this.getSection());
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return getNameAndClubAndSection();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return equals((Member)other);
    }

    public boolean equals(Member other) {
        if (this == other) {
            return true;
        } else {
            return name.equals(other.name);
        }
    }

    @Override
    public int compareTo(Member other) {
        if (this == other) {
            return 0;
        } else {
            return name.compareTo(other.name);
        }
    }

    public String getAddress() {
        if (address != null) {
            return address;
        } else {
            return "";
        }
    }

    public void setAddress(String address) {
        this.address = address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone.trim();
    }

    public String getSHUNumber() {
        return SHUNumber;
    }

    public void setSHUNumber(String SHUNumber) {
        this.SHUNumber = SHUNumber.trim();
    }

    public String getClub()
    {
        return club;
    }

    public void setClub(String club)
    {
        this.club = club.trim();
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section.trim();
    }
}
